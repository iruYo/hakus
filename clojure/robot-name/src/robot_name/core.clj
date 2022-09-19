(ns robot-name.core)

(def letters [\A \B \C \D \E \F \G \H \I \J \K \L \M \N \O \P \Q \R \S \T \U \V \W \X \Y \Z])

(defn generate-name []
  (apply str (concat (take 2 (shuffle letters))
                     (repeatedly 3 #(rand-int 9)))))
(defn robot []
  (atom {:name (generate-name)}))

(defn robot-name [robot]
  (get @robot :name))

(defn reset-name [robot]
  (when (get @robot :name)
    (swap! robot assoc :name (generate-name))))