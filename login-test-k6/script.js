import http from 'k6/http';
import { check, sleep } from 'k6';

const csvData = open('./users.csv').split('\n').slice(1); 

export let options = {
  vus: 20,
  duration: '30s',
};

export default function () {
  const randomLine = csvData[Math.floor(Math.random() * csvData.length)];
  const [user, passwd] = randomLine.split(',');

  const payload = JSON.stringify({
    username: user.trim(),
    password: passwd.trim()
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  let res = http.post('https://fakestoreapi.com/auth/login', payload, params);

  check(res, {
    'Status code is 201': (r) => r.status === 201,
    'Request time < 1.5 s' : (r) => r.timings.duration < 1500,
  });

  //sleep(1);
}