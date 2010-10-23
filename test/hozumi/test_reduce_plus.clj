(ns hozumi.test-reduce-plus
  (:use [hozumi.reduce-plus] :reload)
  (:use [clojure.test]))

(deftest test-reduce+
  (is (= 6 (reduce+ + [1 2 3])))
  (is (= 7 (reduce+ + 1 [1 2 3])))
  (is (= {:c 3, :b 2, :a 1}
	 (reduce+ assoc {} [:a :b :c] [1 2 3])))
  (is (= {:c 1/2, :b 2/5, :a 1/4}
	 (reduce+ #(assoc %1 %2 (/ %3 %4)) {} [:a :b :c] [1 2 3] [4 5 6]))))
