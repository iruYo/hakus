(ns space-age.core-test
  (:require [clojure.test :refer :all]
            [space-age.core :refer :all]))

(defn- rounds-to
  [expected actual]
  (is (= (Math/round (* 100.0 expected))
         (Math/round (* 100.0 actual)))))

(deftest age-in-earth-years
  (rounds-to 31.69 (on-earth 1000000000)))

(deftest age-in-mercury-years
  (let [seconds 2134835688]
    (rounds-to 67.65 (on-earth seconds))
    (rounds-to 280.88 (on-mercury seconds))))

(deftest age-in-venus-years
  (let [seconds 189839836]
    (rounds-to 6.02 (on-earth seconds))
    (rounds-to 9.78 (on-venus seconds))))

(deftest age-on-mars
  (let [seconds 2329871239]
    (rounds-to 73.83 (on-earth seconds))
    (rounds-to 39.25 (on-mars seconds))))

(deftest age-on-jupiter
  (let [seconds 901876382] 
    (rounds-to 28.58 (on-earth seconds))
    (rounds-to 2.41 (on-jupiter seconds))))

(deftest age-on-saturn
  (let [seconds 3000000000]
    (rounds-to 95.06 (on-earth seconds))
    (rounds-to 3.23 (on-saturn seconds))))

(deftest age-on-uranus
  (let [seconds 3210123456]
    (rounds-to 101.72 (on-earth seconds))
    (rounds-to 1.21 (on-uranus seconds))))

(deftest age-on-neptune
  (let [seconds 8210123456]
    (rounds-to 260.16 (on-earth seconds))
    (rounds-to 1.58 (on-neptune seconds))))
