(def stud {"Inese" 10 "Vasja" 8 "Petja" 4 "Natasha" 7 "Anja" 10 "Lauris" 6 "Sandra" 8 "Krišjanis" 9})
(def sorted (select-keys stud (for [[k v] stud :when (= (subs k (- (.length k) 1)) "a")] k)))
(def a (/ (double (reduce + (vals sorted))) (count sorted)))
(println a)
