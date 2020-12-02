(ns advent-of-code.parse
  (:require [clojure.string :as str]))

(defn read-input
  [day]
  (slurp (clojure.java.io/resource day)))

(defn line-integers
  "Reads a file of integers separated by line breaks."
  [input]
  (->> input
       str/split-lines
       (map read-string)))

(defn password-data
  [input]
  (->> input
       str/split-lines
       (map #(str/split % #" "))
       ))

(defn password-line
  [input]
  (let [[fr ch pw] input]
    [(map read-string (re-seq #"[0-9]+" fr)) (first ch) pw]))

;; unused

(defn comma-integers
  "Reads a file of integers separated by line breaks."
  [input]
  (->> (str/split input #",")
       (map read-string)))

(defn wire-paths
  ""
  [input]
  (->> (str/split-lines input)
       (map #(str/split % #","))))

(defn orbits
  ""
  [input]
  (->> (str/split-lines input)
       (map #(str/split % #"\)"))
       set))
