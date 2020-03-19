(ns s3bench.random)

(def ^:private java-random (java.util.Random.))

(def ^:private patterns
  (let [numbers (range 48 58)
        upper-alphabets (range 65 92)
        lower-alphabets (range 97 123)
        chars (concat numbers upper-alphabets lower-alphabets)]
    (map char chars)))

(defn- generate-char []
  (let [idx (.nextInt java-random (count patterns))]
    (nth patterns idx)))

(defn gen-content
  [content-length]
  (let [charseq (repeatedly generate-char)
        randomchars (take content-length charseq)]
    (apply str randomchars)))