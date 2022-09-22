(ns rna-transcription.core)

(def translations {\C "G"
                  \G "C"
                  \A "U"
                  \T "A"})
(defn to-rna3 [dna]
  (->> dna
       (map (fn [part]
              (if-let [translation (translations part)]
                translation
                (throw (AssertionError.)))))
       (apply str)))

(defn to-rna2 [dna]
  (let [translation (map translations dna)]
    (if-not (every? identity translation)
      (throw (AssertionError.))
      (apply str translation))))

(defn to-rna [dna]
  (when (some nil? (map translations dna))
    (throw (AssertionError.)))
  (->> dna
       (map translations)
       (apply str)))