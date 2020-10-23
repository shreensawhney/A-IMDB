#!/bin/bash

NODE_TOTAL=${CIRCLE_NODE_TOTAL:-1}
NODE_INDEX=${CIRCLE_NODE_INDEX:-0}

i=0
tests=()
#for file in $(find / -name "testng_SmokeTest*.xml" 2>&-| sort)
#for file in $(find / -name "testng_Complete-MM-AA-BO.xml" 2>&-| sort)
#for file in $(find / -name "testng_Complete-EA-SA.xml" 2>&-| sort)
#for file in $(find / -name "testng_Complete-TVC.xml" 2>&-| sort)
#for file in $(find / -name "testng_Complete-GEA-GAA-GMM-Insights-Account.xml" 2>&-| sort)
#for file in $(find / -name "testng_Complete*.xml" 2>&-| sort)
#for file in $(find / -name "testng_IndustryOverview*.xml" 2>&-| sort)
#for file in $(find / -name "testng_ShowOverview*.xml" 2>&-| sort)
#for file in $(find / -name "testng_SpotOverview*.xml" 2>&-| sort)
for file in $(find / -name "testng_*Overview*.xml" 2>&-| sort)
#for file in $(find / -name "testng_OTT*.xml" 2>&-| sort)
#for file in $(find / -name "testng_MovieConversions.xml" 2>&-| sort)
do
    basename $file
    if [ $(($i % ${NODE_TOTAL})) -eq ${NODE_INDEX} ]
    then
        test=`basename $file`
        tests+="${test},"
    fi
    ((i++))
done
tests=${tests%?};
echo $tests
mvn -Dsurefire.suiteXmlFiles=${tests} test
