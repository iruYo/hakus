(ns rna-transcription.core-test
  (:require [clojure.test :refer :all]
            [rna-transcription.core :refer :all]))

(deftest transcribes-cytosine-to-guanine
  (is (= "G" (to-rna "C"))))

(deftest transcribes-guanine-to-cytosine
  (is (= "C" (to-rna "G"))))

(deftest transcribes-adenine-to-uracil
  (is (= "U" (to-rna "A"))))

(deftest it-transcribes-thymine-to-adenine
  (is (= "A" (to-rna "T"))))

(deftest it-transcribes-all-nucleotides
  (is (= "UGCACCAGAAUU" (to-rna "ACGTGGTCTTAA"))))

(deftest it-validates-dna-strands
  (is (thrown? AssertionError (to-rna "XCGFGGTDTTAA"))))
