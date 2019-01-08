package com.chengkang.services;

import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

public class DevK8sApiService {
    //k8s api封装库调用
    private static KubernetesClient kubernetesClient;
    private static Config config;

    //初始化 - 连接k8s api server
    public static String init(){
        String initResult = "Init Failed.";
        try {
            config = new ConfigBuilder().withMasterUrl("https://10.96.0.1:443").build();
//            config.setClientCertData("eyJhbGciOiJSUzI1NiIsImtpZCI6IiJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJkaXQiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlY3JldC5uYW1lIjoiZGVmYXVsdC10b2tlbi10OHFxYiIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50Lm5hbWUiOiJkZWZhdWx0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQudWlkIjoiZmYwOTQ0ZTQtMGIzYi0xMWU5LTkyODQtMDAxNjNlMDRhZWI2Iiwic3ViIjoic3lzdGVtOnNlcnZpY2VhY2NvdW50OmRpdDpkZWZhdWx0In0.dtD8sRNw7HYcjlXvGML9mW9uhAym8N2vbTijULeIIgms0o7d0urktXiarfCC5dtWoZCUWsDEg2hyxdXxT2OWSHFcfun9QzYCz1OvaHieHu3bRnq3MnqlwZMA0av3hsQKB2XHAEzRDVUGUvuY7dZcDs6D3Ds52aqtQBNMAdWAxPMn6wLmJkc4FCVfHi6CksDwuz4TqwXMJ1NL8gNQe56bKi2WHQcr_U3dCfICTxu5NMst_6VTKn5BjOuqAM2X94eniSb9ZHX0gZSNLMYaHa92BMIx8-XUu12MgNekplWR5K47eTABnpE4lWyH4HeM63gnBjfxGE2AnsI1FbOD8Tv-HA");
//            config.setCaCertData("eyJhbGciOiJSUzI1NiIsImtpZCI6IiJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJkaXQiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlY3JldC5uYW1lIjoiZGVmYXVsdC10b2tlbi10OHFxYiIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50Lm5hbWUiOiJkZWZhdWx0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQudWlkIjoiZmYwOTQ0ZTQtMGIzYi0xMWU5LTkyODQtMDAxNjNlMDRhZWI2Iiwic3ViIjoic3lzdGVtOnNlcnZpY2VhY2NvdW50OmRpdDpkZWZhdWx0In0.dtD8sRNw7HYcjlXvGML9mW9uhAym8N2vbTijULeIIgms0o7d0urktXiarfCC5dtWoZCUWsDEg2hyxdXxT2OWSHFcfun9QzYCz1OvaHieHu3bRnq3MnqlwZMA0av3hsQKB2XHAEzRDVUGUvuY7dZcDs6D3Ds52aqtQBNMAdWAxPMn6wLmJkc4FCVfHi6CksDwuz4TqwXMJ1NL8gNQe56bKi2WHQcr_U3dCfICTxu5NMst_6VTKn5BjOuqAM2X94eniSb9ZHX0gZSNLMYaHa92BMIx8-XUu12MgNekplWR5K47eTABnpE4lWyH4HeM63gnBjfxGE2AnsI1FbOD8Tv-HA");
            kubernetesClient = new DefaultKubernetesClient(config);
            initResult = "Init Success.";
            System.out.println("init sucess");
        }catch (Exception e){
            System.out.println("can't init discovery service");
        }
        return initResult;
    }

    //列出当前命名空间
    public static NamespaceList listNamespace(){
        NamespaceList namespaceList = new NamespaceList();
        try {
            namespaceList = kubernetesClient.namespaces().list();
            System.out.println("list sucess");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("list failed");
        }
        return namespaceList;
    }

    //列出当前可用节点
    public static NodeList listNode(){
        NodeList nodeList = new NodeList();
        try {
            nodeList = kubernetesClient.nodes().list();
            System.out.println("list sucess");
        }catch (Exception e){
            System.out.println("list failed");
        }
        return nodeList;
    }
}

