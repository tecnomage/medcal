package br.com.medclin.boot.converters;

import org.springframework.core.convert.converter.Converter;

public class LookupConverter implements Converter< LookUpEntity, String> { 
         public String convert(LookUpEntity source) { 
                 return String.valueOf(source.getId()); 
         } 
} 