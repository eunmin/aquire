(ns aquire.core
    (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(defn stock-price [level tiles]
  (if (< tiles 2)
    0
    (let [result (cond
                   (<= tiles 5) (* tiles 100)
                   (<= tiles 10) 600
                   (<= tiles 20) 700
                   (<= tiles 30) 800
                   (<= tiles 40) 900
                   :else 1000)]
      (+ (* level 100) result))))

(defonce corporations
  (atom {"SACKSON" {:level 0 :tiles 0}
         "ZETA"    {:level 0 :tiles 0}
         "HYDRA"   {:level 1 :tiles 0}
         "FUSION"  {:level 1 :tiles 0}
         "AMERICA" {:level 1 :tiles 0}
         "PHOENIX" {:level 2 :tiles 0}
         "QUANTUM" {:level 2 :tiles 0}}))

(defn corp-view [corp-name {:keys [tiles level]}]
  (let [price (stock-price level tiles)
        majority (* price 10)
        minority (/ majority 2)]
    [:div
     [:h2.title corp-name]
     [:div
      [:p.title "STOCK"]
      [:p (str price)]]
     [:div
      [:p.title "MAJORITY"]
      [:p (str majority)]]
     [:div
      [:p.title "MINORITY"]
      [:p (str minority)]]
     [:div
      [:p.title "TILES"]
      [:p (str tiles)]]
     [:button {:on-click (fn [] (swap! corporations #(update-in % [corp-name :tiles] inc)))} "+"]
     [:button {:on-click (fn [] (swap! corporations #(update-in % [corp-name :tiles] dec)))} "-"]]))

(defn main []
  [:div
   (for [[corp-name state] @corporations]
     ^{:key corp-name} [corp-view corp-name state])])

(reagent/render-component [main]
                          (. js/document (getElementById "app")))

(defn on-js-reload [])
