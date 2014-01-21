require 'java'
java_package 'com.cisco.nesal.internal'
java_import 'com.cisco.nesal.plugin.ICommunication'
java_import 'com.cisco.nesal.plugin.ICrypto'
java_import 'com.cisco.nesal.plugin.IPlatformDependent'
java_import 'com.cisco.nesal.plugin.IPlatformIndependent'

class RubySample


#    java_signature 'RubySample(double, double)'
#    def initialize(x, y)
#
#    end

    java_signature 'void configure(ICommunication commImpl, 
                          IPlatformIndependent piImpl,
			  IPlatformDependent pdImpl, 
                          ICrypto cryptoImpl)'
    def configure(a, b, c ,d)

    end


    java_signature 'void bar(int, int)'
    def bar(a,b)
        puts a + b
    end
end


