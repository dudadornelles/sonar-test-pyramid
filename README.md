Sonar Test Pyramid Plugin
=========================

Show stats for your (java) project's [test pyramid](http://martinfowler.com/bliki/TestPyramid.html).

Usage
-----

Add the follwoing parameters to sonar runner or sonar properties:
`sonar.testpyramid.unittests=com.myproject`
`sonar.testpyramid.integrationtests=com.integration.myproject`
`sonar.testpyramid.functionaltests=com.functional.myproject`

Notice that you have to be very specific about the package and there is no priority in case your packages have more than what you are trying to measure. E.g.: if com.myproject has your unit tests, and com.myproject.integration has your integration tests, the plugin can't figure that out and will add you integration tests count to your unit tests.

Pull Requests
------------

Are welcome...
