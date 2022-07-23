(ns nucleotide-count.core-test
  (:require [clojure.test :refer :all]
            [nucleotide-count.core :refer :all]))

(deftest empty-dna-strand-has-no-adenosine
  (is (= 0 (count-of-nucleotide-in-strand \A, ""))))

(deftest empty-dna-strand-has-no-nucleotides
  (is (= {\A 0, \T 0, \C 0, \G 0}
         (nucleotide-counts ""))))

(deftest repetitive-cytidine-gets-counted
  (is (= 5 (count-of-nucleotide-in-strand \C "CCCCC"))))

(deftest repetitive-sequence-has-only-guanosine
  (is (= {\A 0, \T 0, \C 0, \G 8}
         (nucleotide-counts "GGGGGGGG"))))

(deftest counts-only-thymidine
  (is (= 1 (count-of-nucleotide-in-strand \T "GGGGGTAACCCGG"))))

(deftest validates-nucleotides
  (is (thrown? Throwable (count-of-nucleotide-in-strand \X "GACT"))))

(deftest counts-all-nucleotides
  (let [s "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"]
    (is (= {\A 20, \T 21, \G 17, \C 12}
           (nucleotide-counts s)))))