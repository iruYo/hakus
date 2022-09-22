(ns rna-transcription.core)

(def translation {\C "G"
                  \G "C"
                  \A "U"
                  \T "A"})
(defn to-rna [dna]
  (let [translation (map translation dna)]
    (if-not (every? identity translation)
      (throw (AssertionError.))
      (apply str translation))))