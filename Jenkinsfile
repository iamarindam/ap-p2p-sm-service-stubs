@Library('zapp-utilities') _

continuousBuildBoot {
    maven_v = 'Maven 3.6.1'
    java_v = 'openjdk11.28'
    build_goal = 'clean install -Pdev-env-v3,jenkins -DskipTests'
    test_goal = 'test -Pdev-env-v3,jenkins -Djacoco.reportPath.dir=$WORKSPACE/target'
    it_test_goal = 'test -Pdev-env-v3,jenkins -Djacoco.reportPath.dir=$WORKSPACE/target'
    //it_test_goal = 'clean install test -Pdev-env-v3,test-ci,jenkins -e -rf :ap-p2p-sm-service-stubs-itests'
    //sonar_goal = 'sonar:sonar -Psonar,dev-env-v3 -Dsonar.projectKey=ap-p2p-sm-service-stubs -Dsonar.login=${sonar_credentials} -Dsonar.branch.name=$BRANCH_NAME'
    target = 'develop'
    branch = 'develop'
    env = 'cb'
    component = 'ap-p2p-sm-service-stubs'
    agent = 'zapp-dev-env2'
}