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

function main(input) {
    let t = parseInt(input.shift());
    for(let a0 = 0; a0 < t; a0++){
        let n = parseInt(input.shift());
        console.log(largestPalindromeProduct(n));
    }
}

function isPalindrome(n) {
  let original = n;
  let reversed = 0;
  while (n > 1) {
    reversed = (reversed * 10) + (n % 10);
    n = Math.floor(n / 10);
  }
  return original == reversed;
}

function largestPalindromeProduct(n) {
  let largest = 0;
  let max = 10 ** (n) - 1;
  let min = 10 ** (n - 1);
  for (let i = max; i > min; i--) {
    for (let j = i; j > min; j--) {
      let prod = i * j;
      if (prod <= largest) {
        break;
      }else if (isPalindrome(prod)) {
        largest = prod;
        break;
      }
    }
  }
  return largest;
}
