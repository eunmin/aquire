(ns aquire.events
  (:require [re-frame.core :refer [reg-event-db]]))

(reg-event-db
 :initialise-db
 (fn [db _]
   db))
