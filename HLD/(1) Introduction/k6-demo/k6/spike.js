// Spike test: sudden jump in traffic, then back to normal
import http from 'k6/http';
import { check, sleep } from 'k6';

const BASE_URL = __ENV.BASE_URL || 'http://localhost:3000';

export const options = {
  stages: [
    { duration: '10s', target: 10 },  // normal traffic
    { duration: '5s', target: 300 },  // sudden spike
    { duration: '30s', target: 300 }, // stay at the spike
    { duration: '5s', target: 10 },   // drop back
    { duration: '20s', target: 10 },  // check the app recovered
    { duration: '5s', target: 0 },
  ],
  thresholds: {
    http_req_failed: ['rate<0.05'],
    http_req_duration: ['p(95)<1000'],
  },
};

export default function () {
  const res = http.get(`${BASE_URL}/`);
  check(res, { 'status is 200': (r) => r.status === 200 });
  http.get(`${BASE_URL}/slow`);
  sleep(1);
}
