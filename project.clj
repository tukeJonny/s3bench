(defproject s3bench "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [
    [org.clojure/clojure "1.10.0"]
    [clj-aws-s3 "0.3.10"]
    [io.forward/yaml "1.0.10"]
  ]
  :main s3bench.core
  :repl-options {:init-ns s3bench.core})
