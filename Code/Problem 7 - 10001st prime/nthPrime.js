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
        console.log(nthPrime(n)); //print test function
    }
}

//--------------------Code--------------------

function sieveOfTheotostenes(num) {
  let sieve = Array(num+1).fill(true);
  let primes = [];

  for (let i = 2; i*i < num; i++) {
    if (sieve[i]) {
      for (let j = i; j*i < num; j++) {
        sieve[j*i] = false;
      }
    }
  }

  for (let i = 2; i < sieve.length; i++) {
    if (sieve[i]) primes.push(i);
  }

  return primes;
}

const primes = sieveOfTheotostenes(104743);

function nthPrime(n) {
  return primes[n-1];
}