(ns advent-of-code.parse)

(defn read-input
  [day]
  (slurp (clojure.java.io/resource day)))

(defn line-integers
  "Reads a file of integers separated by line breaks."
  [input]
  (->> input
       clojure.string/split-lines
       (map read-string)))

(defn comma-integers
  "Reads a file of integers separated by line breaks."
  [input]
  (->> (clojure.string/split input #",")
       (map read-string)))

(defn wire-paths
  ""
  [input]
  (->> (clojure.string/split-lines input)
       (map #(clojure.string/split % #","))))

(defn orbits
  ""
  [input]
  (->> (clojure.string/split-lines input)
       (map #(clojure.string/split % #"\)"))
       set))
