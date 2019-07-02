package com.laugh.processor;

/**
 * @author yu.gao 2019-02-18 9:09 PM
 */
public interface Context {
    Integer getTag();

    ProcessorPipeline getPipeline();
}
