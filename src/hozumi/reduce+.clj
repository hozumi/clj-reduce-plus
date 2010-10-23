(ns hozumi.reduce+)

(defn- helper [f val colls]
  (let [s1 (seq (first colls))]
    (if s1
      (recur f
	     (apply f val (map first colls))
	     (map next colls))
      val)))
   
(defn reduce+
  ([f coll]
     (let [s (seq coll)]
       (if s
	 (reduce+ f (first s) (next s))
	 (f))))
  ([f val coll]
     (let [s (seq coll)]
       (if s
	 (if (chunked-seq? s)
	   (recur f 
		  (.reduce (chunk-first s) f val)
		  (chunk-next s))
	   (recur f (f val (first s)) (next s)))
	 val)))
  ([f val c1 c2]
     (let [s1 (seq c1)
	   s2 (seq c2)]
       (if s1
	 (recur f (f val (first s1) (first s2)) (next s1) (next s2))
	 val)))
  ([f val c1 c2 & colls]
     (let [s1 (seq c1)
	   s2 (seq c2)
	   scolls (map seq colls)]
       (if s1
	 (helper f
		 (apply f val (first s1) (first s2) (map first scolls))
		 (cons (next s1)
		       (cons (next s2)
			     (map next scolls))))
	 val))))

