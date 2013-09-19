package testapp

import groovy.beans.Bindable

class SecondModel {
    @Bindable String title = "Add a new user"
    @Bindable String message = ""
    @Bindable String name
    @Bindable String password
}