module carnival.exiles {

  requires com.google.gson;

  exports com.carnivalexiles.model;
  opens com.carnivalexiles.model to com.google.gson;
  exports com.carnivalexiles.controller;
  opens com.carnivalexiles.controller to com.google.gson;
  exports com.carnivalexiles.view;
  opens com.carnivalexiles.view to com.google.gson;
  exports  com.carnivalexiles.model.locations;
  opens com.carnivalexiles.model.locations to com.google.gson;

}