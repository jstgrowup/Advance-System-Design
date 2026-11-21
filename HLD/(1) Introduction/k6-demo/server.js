const http = require("http");

const server = http.createServer((req, res) => {
  if (req.url === "/") {
    res.end("Hello");
  } else if (req.url === "/slow") {
    // fake slow work (200ms) so latency shows up in the k6 results
    setTimeout(() => res.end("Hello, slowly"), 200);
  } else {
    res.statusCode = 404;
    res.end("Not found");
  }
});

const PORT = process.env.PORT || 3010;
server.listen(PORT, () =>
  console.log(`Server running on http://localhost:${PORT}`),
);
