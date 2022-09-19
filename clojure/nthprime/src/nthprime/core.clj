(ns nthprime.core)

(defn is-prime? [n] 
  (when (> n 1)
    (not-any? (fn [fac]
                (zero? (rem n fac)))
              (range 2 (dec n)))))

(def primes 
  (filter is-prime? (range)))

(defn nth-prime [n]
  (when (= n 0)
    (throw (IllegalArgumentException. "no 0th prime")))
  (nth primes (- n 1)))

; https://web.archive.org/web/20150710134640/http://diditwith.net/2009/01/20/YAPESProblemSevenPart2.aspx
;(defn sithe [composites number]
;  (if-let [composite (get composites number)]
;    (as-> composite $
;      (reduce #(assoc %1 (+ number %2) (conj (%1 (+ number %2) []) %2)) composites $)
;      (dissoc $ number))
;    (assoc composites (* number number) (vector number))))

; REDUCE DOESNT PRODUCE LAZY SEQ
;(def primes2
; (->> (iterate inc 2)
;      (reduce sithe {})
;      (vals)
;      (flatten)
;      (sort)))

