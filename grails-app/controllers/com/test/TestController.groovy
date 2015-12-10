package com.test

import grails.plugin.springsecurity.annotation.Secured

class TestController {

	@Secured(['ROLE_USER'])
	def user(){
		render "This is a user"
	}
	@Secured(['ROLE_ADMIN'])
	def admin() {
		render "This is a admin"
	}
}
