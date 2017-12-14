package org.server.config;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class WorkerConfigurationTest {
    @org.junit.Test
    public void getExecutorShutdownTimeout() throws Exception {
    }

    @org.junit.Test
    public void setExecutorShutdownTimeout() throws Exception {
    }

    @org.junit.Test
    public void getName() throws Exception {
    }

    @org.junit.Test
    public void setName() throws Exception {
    }

    @org.junit.Test
    public void getTimeoutUnit() throws Exception {
    }

    @org.junit.Test
    public void setTimeoutUnit() throws Exception {
    }

    @org.junit.Test
    public void getThreadPoolSize() throws Exception {
    }

    @org.junit.Test
    public void setThreadPoolSize() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(WorkerConfiguration.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
