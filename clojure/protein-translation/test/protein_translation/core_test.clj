(ns protein-translation.core-test
  (:require [clojure.test :refer :all]
            [protein-translation.core :refer :all]))

(deftest AUG-translates-to-Methionine
  (is (= "Methionine" (translate-codon "AUG"))))

(deftest UGG-translates-to-Tryptophan
  (is (= "Tryptophan" (translate-codon "UGG"))))

(deftest identifies-Phenylalanine-codons
  (are [codon] (= "Phenylalanine" (translate-codon codon)) "UUU" "UUC"))

(deftest identifies-Leucine-codons
  (are [codon] (= "Leucine" (translate-codon codon)) "UUA" "UUG"))

(deftest identiefies-Serine-codons
  (are [codon] (= "Serine" (translate-codon codon)) "UCU" "UCC" "UCA" "UCG"))

(deftest identiefies-Tyrosine-codons
  (are [codon] (= "Tyrosine" (translate-codon codon)) "UAU" "UAC"))

(deftest identifies-Cysteine-codons
  (are [codon] (= "Cysteine" (translate-codon codon)) "UGU" "UGC"))

(deftest identifies-stop-codons
  (are [codon] (= "STOP" (translate-codon codon)) "UAA" "UAG" "UGA"))

(deftest translates-rna-strand-into-correct-protein
  (is (= ["Methionine" "Phenylalanine" "Tryptophan"] (translate-rna "AUGUUUUGG"))))

(deftest stops-translation-if-stop-codon-present
  (is (= ["Methionine" "Phenylalanine"] (translate-rna "AUGUUUUAA"))))

(deftest stops-translation-of-longer-strand
  (is (= ["Tryptophan" "Cysteine" "Tyrosine"] (translate-rna "UGGUGUUAUUAAUGGUUU"))))