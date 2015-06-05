(defproject com.bendyworks/om-counter "0.0.1"
  :source-paths ["src"]
  :dependencies [[org.clojure/clojure "1.7.0-RC1"]
                 [org.clojure/clojurescript "0.0-3308"]
                 [org.omcljs/om "0.8.8"]]
  :plugins [[lein-cljsbuild "1.0.5"]]

  :cljsbuild {
              :builds [{:id "dev"
                        :source-paths ["src"]
                        :compiler {:main com.bendyworks/om-counter
                                   :output-to "out/omCounter.js"
                                   :output-dir "out"
                                   :source-map true
                                   :optimizations :none}}]})
