(ns protein-translation.core)

(def amino-acids {"AUG" "Methionine"
                  "UUU" "Phenylalanine"
                  "UUC" "Phenylalanine"
                  "UUA" "Leucine"
                  "UUG" "Leucine"
                  "UCU" "Serine"
                  "UCC" "Serine"
                  "UCA" "Serine"
                  "UCG" "Serine"
                  "UAU" "Tyrosine"
                  "UAC" "Tyrosine"
                  "UGU" "Cysteine"
                  "UGC" "Cysteine"
                  "UGG" "Tryptophan"
                  "UAA" "STOP"
                  "UAG" "STOP"
                  "UGA" "STOP"})

(defn translate-codon [codon]
  (amino-acids codon))

(defn translate-rna [rna]
  (->> rna
       (re-seq #".{3}")
       (map translate-codon)
       (take-while #(not (= "STOP" %)))))
