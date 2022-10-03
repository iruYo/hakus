(ns space-age.core)

(def orbital-periods {:earth 1 
                      :venus 0.61519726
                      :mercury 0.2408467
                      :mars 1.8808158
                      :jupiter 11.862615
                      :saturn 29.447498
                      :uranus 84.016846
                      :neptune 164.79132})

(defn- on-planet [seconds planet]
  (-> seconds
      (/ 60)
      (/ 1440)
      (/ (* 365.25 (planet orbital-periods)))))

(defn on-earth [seconds]
  (on-planet seconds :earth))

(defn on-mercury [seconds]
  (on-planet seconds :mercury))

(defn on-venus [seconds]
  (on-planet seconds :venus))

(defn on-mars [seconds]
  (on-planet seconds :mars))

(defn on-jupiter [seconds]
  (on-planet seconds :jupiter))

(defn on-saturn [seconds]
  (on-planet seconds :saturn))

(defn on-uranus [seconds]
  (on-planet seconds :uranus))

(defn on-neptune [seconds]
  (on-planet seconds :neptune))

