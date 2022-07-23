(ns isogram.core-test
  (:require [clojure.test :refer :all]
            [isogram.core :refer :all]))

(deftest test-isograms
  (is (isogram? "duplicates"))
  (is (isogram? "subdermatoglyphic"))
  (is (isogram? "thumbscrew-japingly"))
  (is (isogram? "Hjelmqvist-Gryb-Zock-Pfund-Wax"))
  (is (isogram? "Heizölrückstoßabdämpfung"))
  (is (isogram? "Emily Jung Schwartzkopf")))


(deftest test-non-isograms
  (is (not (isogram? "eleven")))
  (is (not (isogram? "Alphabet")))
  (is (not (isogram? "the quick brown fox")))
  (is (not (isogram? "éléphant"))))
