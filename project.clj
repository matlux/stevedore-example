(defproject stevedoretest "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
                                        ; :dependencies [[org.clojure/clojure "1.4.0"]
                                        ;[com.palletops/stevedore "0.8.0-beta.2 ]

  ;]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [com.palletops/stevedore "0.8.0-beta.3"]
                 [org.clojars.hozumi/clj-commons-exec "1.0.6"]]

  :repositories
  {"sonatype" "https://oss.sonatype.org/content/repositories/releases/"}

  :main stevedoretest.core)
