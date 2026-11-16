// Soak test: normal traffic for a long time (finds slow problems like memory leaks)
import http from 'k6/http';
import { check, sleep } from 'k6';

const BASE_URL = __ENV.BASE_URL || 'http://localhost:3000';

export const options = {
  stages: [
    { duration: '2m', target: 20 },  // ramp up
    { duration: '1h', target: 20 },  // stay for a long time (make it longer if you want)
    { duration: '1m', target: 0 },   // ramp down
  ],
  thresholds: {
    http_req_failed: ['rate<0.01'],
    http_req_duration: ['p(95)<500'],
  },
};

export default function () {
  const res = http.get(`${BASE_URL}/`);
  check(res, { 'status is 200': (r) => r.status === 200 });
  http.get(`${BASE_URL}/slow`);
  sleep(1);
}
