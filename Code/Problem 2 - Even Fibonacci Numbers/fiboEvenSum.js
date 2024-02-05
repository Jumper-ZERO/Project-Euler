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

function fiboEvenSum(n) {
  let [n1, n2, n3] = [1, 1, 2];
  let sum = 0;
  while (n3 <= n) {
    sum += n3;
    [n1, n2, n3] = [n3 + n2, n3 * 2 + n2, n3 * 3 + n2 * 2];
  }
  return sum;
}

function main(input) {
    let t = parseInt(input.shift());
    for(let a0 = 0; a0 < t; a0++){
        let n = parseInt(input.shift());
        console.log(fiboEvenSum(n));
    }
}