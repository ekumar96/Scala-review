println(1 + 2)


def abs(x: Double): Double = if(x >= 0) x else -x

abs(3)
abs(-3)


def originalIsCloseEnough(guess: Double, x: Double): Boolean = {
    abs(guess*guess - x) <= 0.001
}

def isCloseEnough(guess: Double, x: Double): Boolean = {
    abs(guess * guess - x) / x <= 0.001
}

def improve(guess: Double, x: Double): Double = { // Core, Newton method (mean of cur guess and x/guess)
    (x / guess + guess) / 2
}

def sqrtIter(guess: Double, x: Double): Double = {
    if(isCloseEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)
}

def sqrt(x: Double): Double = { 
    sqrtIter(1.0, x)
}

sqrt(4)
sqrt(2)

// Without improved method above, small input would result in bad, because not enough precision, and too large would just circle the drain and not terminate
// Improved method fixes this by scaling precision to huge number
sqrt(1e-6) 
sqrt(1e60) 