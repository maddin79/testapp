package testapp

import groovy.beans.Bindable

class FirstUserModel {
    @Bindable String title
    @Bindable int width = 0
    @Bindable int height = 0
    @Bindable boolean resizable = true
    @Bindable boolean modal = true
    @Bindable String name = ''
    @Bindable String password = ''
}
