(require '[clojure.string :as string])

(defn abs [n] 
  (max n (- n)))

(defn replace_spaces [str]
  (clojure.string/replace str #" " "_"))

(defn create_vector[rows] 
  (vec (repeat rows [])))

(defn get_row [rows idx]
  (- (- rows 1) (abs (- (- rows 1) (mod idx (* 2 (- rows 1)))))))

(defn get_tuple [str key]
  (map-indexed (fn [idx itm] [(get_row key idx) itm idx]) str))

(defn encrypt [str key]
  (let [vec (create_vector key)]
    (string/join
      (map string/join
        (reduce (fn [carry item]
          (let [idx (get item 0) char (get item 1)]
            (assoc carry idx (conj (get carry idx) char))))
              (create_vector 3)
                (get_tuple (replace_spaces str) key))))))
                          
(defn decrypt [str key]
  (let [vec (create_vector key)]
    (string/join
      (map-indexed (fn [idx itm]
        (.charAt str
          (.indexOf (flatten
            (reduce (fn [carry item]
              (let [idx (get item 0) char (get item 1)]
                (assoc carry idx (conj (get carry idx) (get item 2)))))
                  (create_vector 3)
                    (get_tuple (replace_spaces str) key)))
             idx)))
        str))))

(def str "In the rail fence cipher the plain text is written downwards and diagonally on successive rails of an imaginary fence")
(println "-----------------------------------------------------------------------")
(println "key = 2")
(def key 2)
(def encrypted (encrypt str key))
(def decrypted (decrypt encrypted key))
(println str)
(println encrypted)
(println decrypted)
(println "")
(println "-----------------------------------------------------------------------")
(println "key = 3")
(def key 2)
(def encrypted (encrypt str key))
(def decrypted (decrypt encrypted key))
(println str)
(println encrypted)
(println decrypted)
(println "")
(println "-----------------------------------------------------------------------")
(println "key = 4")
(def key 2)
(def encrypted (encrypt str key))
(def decrypted (decrypt encrypted key))
(println str)
(println encrypted)
(println decrypted)
(println "")