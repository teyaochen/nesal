package com.cisco.nesal.internal;

import org.jruby.Ruby;
import org.jruby.RubyObject;
import org.jruby.runtime.Helpers;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.javasupport.JavaUtil;
import org.jruby.RubyClass;
import com.cisco.nesal.plugin.ICommunication;
import com.cisco.nesal.plugin.ICrypto;
import com.cisco.nesal.plugin.IPlatformDependent;
import com.cisco.nesal.plugin.IPlatformIndependent;


public class RubySample extends RubyObject  {
    private static final Ruby __ruby__ = Ruby.getGlobalRuntime();
    private static final RubyClass __metaclass__;

    static {
        String source = new StringBuilder("require 'java'\n" +
            "java_package 'com.cisco.nesal.internal'\n" +
            "java_import 'com.cisco.nesal.plugin.ICommunication'\n" +
            "java_import 'com.cisco.nesal.plugin.ICrypto'\n" +
            "java_import 'com.cisco.nesal.plugin.IPlatformDependent'\n" +
            "java_import 'com.cisco.nesal.plugin.IPlatformIndependent'\n" +
            "\n" +
            "class RubySample\n" +
            "\n" +
            "\n" +
            "    java_signature 'RubySample(double, double)'\n" +
            "    def initialize(x, y)\n" +
            "\n" +
            "    end\n" +
            "\n" +
            "    java_signature 'void configure(ICommunication commImpl, \n" +
            "                          IPlatformIndependent piImpl,\n" +
            "			  IPlatformDependent pdImpl, \n" +
            "                          ICrypto cryptoImpl)'\n" +
            "    def configure(a, b, c ,d)\n" +
            "\n" +
            "    end\n" +
            "\n" +
            "\n" +
            "    java_signature 'void bar(int, int)'\n" +
            "    def bar(a,b)\n" +
            "        puts a + b\n" +
            "    end\n" +
            "end\n" +
            "\n" +
            "x = RubySample.new\n" +
            "puts x(1,2)\n" +
            "").toString();
        __ruby__.executeScript(source, "/home/tychen/GitForNESAL/nesal/src/main/ruby/sample.rb");
        RubyClass metaclass = __ruby__.getClass("RubySample");
        if (metaclass == null) throw new NoClassDefFoundError("Could not load Ruby class: RubySample");
        metaclass.setRubyStaticAllocator(RubySample.class);
        __metaclass__ = metaclass;
    }

    /**
     * Standard Ruby object constructor, for construction-from-Ruby purposes.
     * Generally not for user consumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    private RubySample(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    /**
     * A static method used by JRuby for allocating instances of this object
     * from Ruby. Generally not for user comsumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    public static IRubyObject __allocate__(Ruby ruby, RubyClass metaClass) {
        return new RubySample(ruby, metaClass);
    }

    
    public  RubySample(double x, double y) {
        this(__ruby__, __metaclass__);
        IRubyObject ruby_arg_x = JavaUtil.convertJavaToRuby(__ruby__, x);
        IRubyObject ruby_arg_y = JavaUtil.convertJavaToRuby(__ruby__, y);
        Helpers.invoke(__ruby__.getCurrentContext(), this, "initialize", ruby_arg_x, ruby_arg_y);

    }

    
    public void configure(ICommunication commImpl, IPlatformIndependent piImpl, IPlatformDependent pdImpl, ICrypto cryptoImpl) {
        IRubyObject ruby_args[] = new IRubyObject[4];
        ruby_args[0] = JavaUtil.convertJavaToRuby(__ruby__, commImpl);
        ruby_args[1] = JavaUtil.convertJavaToRuby(__ruby__, piImpl);
        ruby_args[2] = JavaUtil.convertJavaToRuby(__ruby__, pdImpl);
        ruby_args[3] = JavaUtil.convertJavaToRuby(__ruby__, cryptoImpl);

        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "configure", ruby_args);
        return;

    }

    
    public void bar(int a, int b) {
        IRubyObject ruby_arg_a = JavaUtil.convertJavaToRuby(__ruby__, a);
        IRubyObject ruby_arg_b = JavaUtil.convertJavaToRuby(__ruby__, b);
        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "bar", ruby_arg_a, ruby_arg_b);
        return;

    }

}
