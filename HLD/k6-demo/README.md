# k6-demo

A very basic Node server (built-in `http` module, no packages) with k6 performance tests.

## Routes

- `/` replies instantly
- `/slow` replies after 200ms

## Run

1. Install k6 once: `brew install k6`
2. Start the server: `npm start`
3. In another terminal, run one of the tests:
   - `npm run test:load`
   - `npm run test:spike`
   - `npm run test:stress`
   - `npm run test:soak` (takes about 1 hour)

## Different port

Port 3000 busy? Use another one:

- `PORT=3001 npm start`
- `BASE_URL=http://localhost:3001 npm run test:load`
