import stdio
import stdrandom
import sys


# Generates and returns the public/private keys as a tuple (n, e, d). Prime numbers p and q
# needed to generate the keys are picked from the interval [lo, hi).
def keygen(lo, hi):
    primes = _primes(lo, hi)
    p, q = _sample(primes, 2)
    n = p * q
    m = (p - 1) * (q - 1)
    primes = _primes(2, m)
    e = _choice(primes)
    while m % e == 0:
        e = _choice(primes)
    d = 1
    while d < m:
        if e * d % m == 1:
            break
        d += 1
    return n, e, d


# Encrypts x (int) using the public key (n, e) and returns the encrypted value.
def encrypt(x, n, e):
    return x ** e % n


# Decrypts y (int) using the private key (n, d) and returns the decrypted value.
def decrypt(y, n, d):
    return y ** d % n


# Returns the least number of bits needed to represent n.
def bitLength(n):
    return len(bin(n)) - 2


# Returns the binary representation of n expressed in decimal, having the given width, and padded
# with leading zeros.
def dec2bin(n, width):
    return format(n, '0%db' % width)


# Returns the decimal representation of n expressed in binary.
def bin2dec(n):
    return int(n, 2)


# Returns a list of primes from the interval [lo, hi).
def _primes(lo, hi):
    primes = []
    for p in range(lo, hi):
        if p < 2:
            continue
        i = 2
        while i <= p / i:
            if p % i == 0:
                break
            i += 1
        if i > p / i:
            primes += [p]
    return primes


# Returns a list containing a random sample (without replacement) of k items from the list a.
def _sample(a, k):
    b = a[:]
    for i in range(k):
        r = stdrandom.uniformInt(i, len(a))
        temp = b[i]
        b[i] = b[r]
        b[r] = temp
    return b[:k]


# Returns a random item from the list a.
def _choice(a):
    r = stdrandom.uniformInt(0, len(a))
    return a[r]


# Unit tests the library [DO NOT EDIT].
def _main():
    x = ord(sys.argv[1])
    n, e, d = keygen(25, 100)
    encrypted = encrypt(x, n, e)
    stdio.writef('encrypt(%c) = %d\n', x, encrypted)
    decrypted = decrypt(encrypted, n, d)
    stdio.writef('decrypt(%d) = %c\n', encrypted, decrypted)
    width = bitLength(x)
    stdio.writef('bitLength(%d) = %d\n', x, width)
    xBinary = dec2bin(x, width)
    stdio.writef('dec2bin(%d) = %s\n', x, xBinary)
    stdio.writef('bin2dec(%s) = %d\n', xBinary, bin2dec(xBinary))


if __name__ == '__main__':
    _main()
