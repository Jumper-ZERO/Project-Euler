const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', (line) => {
    input.push(line);
});

rl.on('close', () => {
    main(input);
});

function largestPrimeFactor(n) {
  let largest = -1;

  while (n % 2 == 0) {
    n /= 2;
    largest = 2;
  }

  for (let i = 3; i <= Math.sqrt(n); i += 2) {
    while (n % i == 0) {
      n /= i;
      largest = i;
    }
  }
  if (n > 2)
    largest = n;

  return largest;
}

function main(input) {
    let t = parseInt(input.shift());
    for(let a0 = 0; a0 < t; a0++){
        let n = parseInt(input.shift());
        console.log(largestPrimeFactor(n));
    }
}