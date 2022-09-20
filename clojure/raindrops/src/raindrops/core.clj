(ns raindrops.core)

(defn choose [a b]
  (apply str (or (seq a) (seq b))))

; https://blog.klipse.tech/clojure/2020/09/11/fizbuzz-clj.html
; Create single word sequences definded by their frequency of occouring. (mod % 3 = 0 => every third element)
; Create words sequence by combining all word sequences into one (apply str)
;  -> overlapping words are concated together
; Create a numbers sequence, partialy because choosing function cannot create seq out of number, partialy because tests require a string value returned.
; Choose function receives word (maybe empty) first and number as string second and returns first of which can be made into a sequence (or returns first truthy value)
; Order is imporant, since number string always exists and can be made into a sequence, it would always return first. Word always has to be checked first.
; Finally map the choose function over words and numbers

(def rainddrop-seq
  (let [plings (cycle ["" "" "Pling"])             ; 3
        plangs (cycle ["" "" "" "" "Plang"])       ; 5
        plongs (cycle ["" "" "" "" "" "" "Plong"]) ; 7
        words (map str plings plangs plongs)
        numbers (map str (rest (range)))]
    (map choose words numbers)))

(defn convert [n]
  (nth rainddrop-seq (- n 1)))
