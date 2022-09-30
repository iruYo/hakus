(ns rna-transcription.core)

(def translations {\C "G"
                  \G "C"
                  \A "U"
                  \T "A"})

(defn dna-nucleotide->rna-nucleotide [dna-nucleotide]
    (if-let [translation (translations dna-nucleotide)]
      translation
      (throw (AssertionError.))))

(defn to-rna [dna]
  (->> dna
       (map dna-nucleotide->rna-nucleotide)
       (apply str)))

(defn to-rna2 [dna]
  (let [translation (map translations dna)]
    (if-not (every? identity translation)
      (throw (AssertionError.))
      (apply str translation))))

(defn to-rna1 [dna]
  (when (some nil? (map translations dna))
    (throw (AssertionError.)))
  (->> dna
       (map translations)
       (apply str)))