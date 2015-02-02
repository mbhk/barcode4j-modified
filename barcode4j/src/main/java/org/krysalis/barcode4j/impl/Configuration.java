/*
 * Copyright 2015 mk.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.krysalis.barcode4j.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xml.sax.SAXException;

/**
 *
 * @author mk
 */
public class Configuration {
    private final String name;
    private Object value;
    private final Map<String, Configuration> childs = new HashMap<String, Configuration>();
    private final Map<String, String> attributes = new HashMap<String, String>();

    public Configuration(String name) {
        this.name = name;
    }
    
    public String getValue() {
        return value.toString();
    }
    
    public String getValue(Object defaultValue) {
        if (value == null) {
            return defaultValue == null ? null : defaultValue.toString();
        } else {
            return value.toString();
        }
    }

    public Configuration getChild(String name, boolean returnDefault) {
        if (returnDefault) {
            return getChild(name);
        } else {
            return childs.get(name);
        }
    }

    public Configuration getChild(String name) {
        return childs.containsKey(name) ? childs.get(name) : new Configuration(name);
    }


    
    public boolean getAttributeAsBoolean(String name, boolean defaultValue) {
        String attr = attributes.get(name);
        if (attr == null) {
            return defaultValue;
        } else {
            return Boolean.valueOf(attr);
        }
    }

    public Configuration[] getChildren() {
        return childs.values().toArray(new Configuration[0]);
    }

    public double getValueAsFloat(double defaultValue) {
        if (value == null) {
            return defaultValue;
        } else {
            return Double.valueOf(value.toString());
        }
    }

    public boolean getValueAsBoolean(boolean defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getValueAsBoolean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getValueAsInteger() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getValueAsInteger(int defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getValueAsFloat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public void setAttribute(String name, String value) {
        attributes.put(name, value);
    }

    public void addChild(Configuration childConfiguration) {
        if (childConfiguration != null) {
            childs.put(childConfiguration.getName(), childConfiguration);
        }
    }

    public void setValue(String value) {
        this.value = value; 
    }

    public String getAttribute(String name) throws ConfigurationException {
        return attributes.get(name);
    }

    public static class Builder {

        public Builder() {
        }

        public Configuration buildFromFile(File configurationFile) throws SAXException, IOException, ConfigurationException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
