# clj-reduce+

Clj-reduce+ can take more than two sequence as arg.

## Usage

    (use 'hozumi.reduce+)

    (reduce+ assoc {} [:a :b :c] [1 2 3]) ;take 2 sequence.
    ;=> {:c 3, :b 2, :a 1}

    (reduce+ #(assoc %1 %2 (/ %3 %4)) {} [:a :b :c] [1 2 3] [4 5 6])
    ;=> {:c 1/2, :b 2/5, :a 1/4}   ;take 3 sequence.
    
## Installation

Leiningen
    [org.clojars.hozumi/clj-reduce+ "1.0.0-SNAPSHOT"]
