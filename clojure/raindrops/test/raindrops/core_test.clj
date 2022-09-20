(ns raindrops.core-test
  (:require [clojure.test :refer :all]
            [raindrops.core :refer :all]))

(deftest one
  (is (= "1" (convert 1))))

(deftest three
  (is (= "Pling" (convert 3))))

(deftest five
  (is (= "Plang" (convert 5))))

(deftest seven
  (is (= "Plong" (convert 7))))

(deftest six
  (is (= "Pling" (convert 6))))

(deftest nine
  (is (= "Pling" (convert 9))))

(deftest ten
  (is (= "Plang" (convert 10))))

(deftest fourteen
  (is (= "Plong" (convert 14))))

(deftest fifteen
  (is (= "PlingPlang" (convert 15))))

(deftest twenty-one
  (is (= "PlingPlong" (convert 21))))

(deftest twenty-five
  (is (= "Plang" (convert 25))))

(deftest thirty-five
  (is (= "PlangPlong" (convert 35))))

(deftest forty-nine
  (is (= "Plong" (convert 49))))

(deftest fifty-two
  (is (= "52" (convert 52))))

(deftest one-hundred-five
  (is (= "PlingPlangPlong" (convert 105))))

(deftest twelve-thousand-one-hundred-twenty-one
  (is (= "12121" (convert 12121))))
