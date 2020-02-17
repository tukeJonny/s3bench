(ns s3bench.s3
    (:require [aws.sdk.s3 :as s3]))

(def creds {:access-key , :secret-key , :endpoint })

(defn into-creds
    "Returns dictionary of credentials passed by args"
    [access-key secret-key endpoint]
    {
        :access-key access-key
        :secret-key secret-key
        :endpoint endpoint })

; (s3/delete-bucket creds "nyan"))
; (println (s3/list-buckets creds)))
; (s3/put-object creds "test1" "hello.txt" "some-value"))
; (println (slurp (:content (s3/get-object creds "test1" "hello.txt")))))

