(ns aquire.views)

(defn header []
  [:nav.navbar
   [:div.navbar-brand
    [:h1.title "aquire"]]
   [:div.navbar-menu
    [:div.navbar-start
     [:a.navbar-item ""]]]])

(defn board []
  [:div
   (for [i (range 0 9)]
     [:div.container
      [:div.columns.is-variable.is-1
       (for [j (range 0 12)]
         [:div.column.is-1
          (let [title (str (+ j 1) (char (+ 65 i)))]
            (if (or (and (= j 7) (= i 4))
                    (and (= j 3) (= i 4))
                    (and (= j 1) (= i 3)))
              [:p.notification.has-text-centered.is-primary title]
              [:p.notification.has-text-centered title]))])]])])

(defn corporatoin-status []
  [:table.table
   [:thead
    [:tr
     [:th ""]
     [:th "Corporation"]
     [:th "Price"]
     [:th "Tiles"]
     [:th "Stock"]
     [:th "Majority"]
     [:th "Minority"]]]
   [:tbody
    [:tr
     [:td "O"]
     [:td "SACKSON"]
     [:td "200"]
     [:td "2"]
     [:td "12"]
     [:td "2000"]
     [:td "1000"]]
    [:tr
     [:td "O"]
     [:td "ZETA"]
     [:td "200"]
     [:td "2"]
     [:td "12"]
     [:td "2000"]
     [:td "1000"]]
    [:tr
     [:td "O"]
     [:td "HYDRA"]
     [:td "200"]
     [:td "2"]
     [:td "12"]
     [:td "2000"]
     [:td "1000"]]
    [:tr
     [:td ""]
     [:td "FUSION"]
     [:td "200"]
     [:td "2"]
     [:td "12"]
     [:td "2000"]
     [:td "1000"]]
    [:tr
     [:td "O"]
     [:td "AMERICA"]
     [:td "1200"]
     [:td "22"]
     [:td "12"]
     [:td "12000"]
     [:td "11000"]]
    [:tr
     [:td ""]
     [:td "PHOENIX"]
     [:td "200"]
     [:td "2"]
     [:td "12"]
     [:td "2000"]
     [:td "1000"]]
    [:tr
     [:td ""]
     [:td "QUANTUM"]
     [:td "200"]
     [:td "2"]
     [:td "12"]
     [:td "2000"]
     [:td "1000"]]]])

(defn player-status []
  [:table.table
   [:thead
    [:tr
     [:th "Name"]
     [:th "Money"]
     [:th "Stock"]
     [:th "Turn"]]]
   [:tbody
    [:tr
     [:td "eunmin"]
     [:td "1000"]
     [:td "12"]
     [:td ""]]
    [:tr.is-selected
     [:td "eunha"]
     [:td "1000"]
     [:td "22"]
     [:td "O"]]
    [:tr
     [:td "jenny"]
     [:td "1000"]
     [:td "19"]
     [:td ""]]]])

(defn content []
  [:div.columns
   [:div.column.is-three-quarters
    [board]]
   [:div.column
    [:div.container
     [corporatoin-status]
     [player-status]]]])


(defn aquire-app []
  [:div.container
   [header]
   [content]])
